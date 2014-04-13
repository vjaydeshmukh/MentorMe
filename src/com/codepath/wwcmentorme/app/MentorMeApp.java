package com.codepath.wwcmentorme.app;

import android.content.Context;

import com.codepath.wwcmentorme.helpers.Constants;
import com.codepath.wwcmentorme.models.Skill;
import com.codepath.wwcmentorme.models.User;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.parse.Parse;
import com.parse.ParseObject;

public class MentorMeApp extends com.activeandroid.app.Application {
	private static Context context;
	
    @Override
    public void onCreate() {
        super.onCreate();
        MentorMeApp.context = this;
        initializeParse();
       
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
        		cacheInMemory().cacheOnDisc().build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
            .defaultDisplayImageOptions(defaultOptions)
            .build();
        ImageLoader.getInstance().init(config);
    }
    
    private void initializeParse(){
    	ParseObject.registerSubclass(User.class);
    	ParseObject.registerSubclass(Skill.class);
    	Parse.initialize(this, Constants.PARSE_APPLICATION_ID, Constants.PARSE_CLIENT_KEY);
    }
    
}