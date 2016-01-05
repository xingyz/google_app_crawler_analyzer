package com.factrus.example.table;

import javafx.beans.property.SimpleStringProperty;


public class ApplicationModel {

	private final SimpleStringProperty name;
    private final SimpleStringProperty developer;
    private final SimpleStringProperty category;
 
    public ApplicationModel(String name, String developer, String category) {
        this.name = new SimpleStringProperty(name);
        this.developer = new SimpleStringProperty(developer);
        this.category = new SimpleStringProperty(category);
    }
 
    public String getName() {
        return name.get();
    }
    public void setName(String fName) {
        name.set(fName);
    }
        
    public String getDeveloper() {
        return developer.get();
    }
    public void setDeveloper(String fName) {
        developer.set(fName);
    }
    
    public String getCategory() {
        return category.get();
    }
    public void setCategory(String fName) {
        category.set(fName);
    }
	
}
