package com.example.demo.model;

public enum Gender {
	
	    MALE("male"),
	    FEMALE("female");
	
	    Gender(String string) {
			this.value=string;
		}

		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
		
		
}
