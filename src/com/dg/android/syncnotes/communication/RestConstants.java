package com.dg.android.syncnotes.communication;

public class RestConstants {
	public static final String BASE_URL = "http://simple-android-webservice.herokuapp.com/";
	public static final String CATEGORIES_GET = BASE_URL + "categories.json";
	public static final String CATEGORIES_POST = BASE_URL + "categories.json";
	public static final String CATEGORIES_PUT = BASE_URL + "categories/%s.json";
	public static final String CATEGORIES_DELETE = BASE_URL + "categories/%s.json";


	public static final String NOTES_GET = BASE_URL + "/categories/%s/notes.json";
	public static final String NOTES_POST = BASE_URL + "/categories/%s/notes.json";
	public static final String NOTES_PUT = BASE_URL + "categories/%s/notes/%s.json";
	public static final String NOTES_DELETE = BASE_URL + "categories/%s/notes/%s.json";

}
