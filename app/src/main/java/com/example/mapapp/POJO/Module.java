package com.example.mapapp.POJO;

public class Module {

    private String moduleName;
    private int moduleResId;

    public Module() {
    }

    public Module(String moduleName, int moduleResId) {
        this.moduleName = moduleName;
        this.moduleResId = moduleResId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getModuleResId() {
        return moduleResId;
    }
}
