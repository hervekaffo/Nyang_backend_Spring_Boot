package com.kaffotek.nyang.security;

import com.kaffotek.nyang.SpringApplicationContext;

public class SecurityConstants {
	public static final long EXPIRATION_TIME = 864000000; // 10 days
	public static final long PASSWORD_RESET_EXPIRATION_TIME = 3600000; // 1 hour
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users";
	public static final String GET_ROUNDS_URL = "/rounds";
	public static final String VERIFICATION_EMAIL_URL = "/users/email-verification";
	public static final String PASSWORD_RESET_REQUEST_URL = "/users/password-reset-request";
	public static final String PASSWORD_RESET_URL = "/users/password-reset";
	public static final String H2_CONSOLE = "/h2-console/**";
	public static final String UPDATE_ROUNDS_URL = "/rounds/**";
	public static final String POST_ROUNDS_URL = "/rounds";
	public static final String GET_ROUND_URL = "/rounds/**";
	public static final String SIGN_IN_URL = "/users/login";

	// Meals
	public static final String UPDATE_MEALS_URL = "/meals/**";
	public static final String POST_MEALS_URL = "/meals/**";
	public static final String GET_MEALS_URL = "/meals";
	public static final String GET_MEAL_URL = "/meals/**";
	public static final String DELETE_MEALS_URL = "/meals/**";

	// Pickups
	public static final String UPDATE_PICKUPS_URL = "/pickups/**";
	public static final String POST_PICKUPS_URL = "/pickups/**";
	public static final String GET_PICKUPS_URL = "/pickups";
	public static final String GET_PICKUP_URL = "/pickups/**";
	public static final String DELETE_PICKUPS_URL = "/pickups/**";

	public static String getTokenSecret() {
		AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
		return appProperties.getTokenSecret();
	}

}
