package com.example.demo;


import java.util.List;


public class Print implements Command {

    private View view;
    private DatabaseManager manager;
    private String tableName;

    public Print(View view, DatabaseManager manager) {
        this.view = view;
        this.manager = manager;
    }

    public boolean canProcess(String command) {
        return command.startsWith("print ");
    }

    public void process(String input) {
        String[] command = input.split(" ");
        if (command.length != 2) {
            throw new IllegalArgumentException("incorrect number of parameters. Expected 1, but is " + (command.length - 1));
        }
        tableName = command[1];
        List<DataSet> data = manager.getTableData(tableName);
        Table table = new Table(data,tableName);
        view.write(table.getTableString());
        System.out.println(table.getTableString());
    }

}

