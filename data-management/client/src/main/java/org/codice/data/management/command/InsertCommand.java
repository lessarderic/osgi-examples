package org.codice.data.management.command;

import org.codice.data.management.DataManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = InsertCommand.class, //
        property = { //
                "osgi.command.scope=data", //
                "osgi.command.function=insert", //
                "osgi.command.function=update", //
                "osgi.command.function=delete" //
        })
public class InsertCommand {

    private DataManager dataManager;

    public void insert(String key, String value) throws Exception {
        dataManager.insert(key, value);
        System.out.println(String.format("Inserted (Key: %s, Value: %s)", key, value));
    }

    public void update(String key, String value) {
        dataManager.update(key, value);
        System.out.println(String.format("Updated (Key: %s, Value: %s)", key, value));
    }

    public void delete(String key) {
        dataManager.delete(key);
        System.out.println(String.format("Deleted (Key: %s)", key));
    }

    @Reference
    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }
}
