package com.android.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.webservice.WebServiceManager;

/**
 * This class is used for parsing the server data either in xml or JSON format and providing the respective output
 * 
 * 
 * @author Sanjib
 *
 */
public class Parser {

	// Variables declaration

	String response;

	private int id;
	private String firstName;
	private String lastName;
	private String nickName;
	private String mobileno;
	private String landlineno;
	private String username;

	private int rollid;
	private int locationId;
	private int mangerUserId;
	private int workTypeId;

	private String serviceBeginDate;
	private String serviceEndDate;
	private String createdDateTime;

	private int createdUserId;
	private String updatedDateTime;

	private int updatedUserId;

	private boolean deleteFlag;

	JSONObject jsonObject = null;

	WebServiceManager webServiceManager;

	/**
	 * Constructor is used to initialize
	 */
	public Parser() {

		webServiceManager = new WebServiceManager();

	}

	/**
	 * This method is used for getting user details response from url
	 * @return response
	 */
	public String getWebServiceManagerUserDetails() {

		response = webServiceManager.getUserDetails(Constants.SERVER_PATH, Constants.GET_USER_DETAILS_PATH);
		return response;

	}

	/**
	 * This method provides the server data in form of json object
	 * @return jsonObject
	 */
	public JSONObject getServerData() {

		try {
			JSONArray jsonArray = new JSONArray(getWebServiceManagerUserDetails());
			jsonObject = jsonArray.getJSONObject(0);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;

	}

	/**
	 * This method provides the userDetails id
	 * @return id
	 */
	public int getUserDetails_id() {

		try {
			if(getServerData() != null) {
				id = getServerData().getInt(Constants.USERMAIL_ID);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return id;

	}

	/**
	 * This method provides the userDetails firstname
	 * @return firstname
	 */
	public String getUserDetails_firstName() {

		try {
			if(getServerData() != null) {
				firstName = getServerData().getString(Constants.USERMAIL_FIRST_NAME);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return firstName;

	}

	/**
	 * This method provides the userDetails lastName
	 * @return lastName
	 */
	public String getUserDetails_lastName() {

		try {
			if(getServerData() != null) {
				lastName = getServerData().getString(Constants.USERMAIL_LAST_NAME);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return lastName;

	}

	/**
	 * This method provides the userDetails nickName
	 * @return nickName
	 */
	public String getUserDetails_nickName() {

		try {
			if(getServerData() != null) {
				nickName = getServerData().getString(Constants.USERMAIL_NICK_NAME);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return nickName;

	}

	/**
	 * This method provides the userDetails mobileno
	 * @return mobileno
	 */
	public String getUserDetails_mobileno() {

		try {
			if(getServerData() != null) {
				mobileno = getServerData().getString(Constants.USERMAIL_MOBILE_NUMBER);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return mobileno;

	}

	/**
	 * This method provides the userDetails landlineno
	 * @return landlineno
	 */
	public String getUserDetails_landlineno() {

		try {
			if(getServerData() != null) {
				landlineno = getServerData().getString(Constants.USERMAIL_LANDLINE_NUMBER);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return landlineno;

	}

	/**
	 * This method provides the userDetails username
	 * @return username
	 */
	public String getUserDetails_username() {

		try {
			if(getServerData() != null) {
				username = getServerData().getString(Constants.USERMAIL_USER_NAME);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return username;

	}

	/**
	 * This method provides the userDetails rollid
	 * @return rollid
	 */
	public int getUserDetails_rollid() {

		try {
			if(getServerData() != null) {
				rollid = getServerData().getInt(Constants.USERMAIL_ROLL_ID);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return rollid;

	}

	/**
	 * This method provides the userDetails locationId
	 * @return locationId
	 */
	public int getUserDetails_locationId() {

		try {
			if(getServerData() != null) {
				locationId = getServerData().getInt(Constants.USERMAIL_LOCATION_ID);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return locationId;

	}

	/**
	 * This method provides the userDetails mangerUserId
	 * @return mangerUserId
	 */
	public int getUserDetails_mangerUserId() {

		try {
			if(getServerData() != null) {
				mangerUserId = getServerData().getInt(Constants.USERMAIL_MANAGERUSER_ID);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return mangerUserId;

	}

	/**
	 * This method provides the userDetails workTypeId
	 * @return workTypeId
	 */
	public int getUserDetails_workTypeId() {

		try {
			if(getServerData() != null) {
				workTypeId = getServerData().getInt(Constants.USERMAIL_WORKTYPE_ID);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return workTypeId;

	}

	/**
	 * This method provides the userDetails serviceBeginDate
	 * @return serviceBeginDate
	 */
	public String getUserDetails_serviceBeginDate() {

		try {
			if(getServerData() != null) {
				serviceBeginDate = getServerData().getString(Constants.USERMAIL_SERVICE_BEGINDATE);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return serviceBeginDate;

	}

	/**
	 * This method provides the userDetails serviceEndDate
	 * @return serviceEndDate
	 */
	public String getUserDetails_serviceEndDate() {

		try {
			if(getServerData() != null) {
				serviceEndDate = getServerData().getString(Constants.USERMAIL_SERVICE_ENDDATE);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return serviceEndDate;

	}

	/**
	 * This method provides the userDetails createdDateTime
	 * @return createdDateTime
	 */
	public String getUserDetails_createdDateTime() {

		try {
			if(getServerData() != null) {
				createdDateTime = getServerData().getString(Constants.USERMAIL_CREATED_DATETIME);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return createdDateTime;

	}

	/**
	 * This method provides the userDetails createdUserId
	 * @return createdUserId
	 */
	public int getUserDetails_createdUserId() {

		try {
			if(getServerData() != null) {
				createdUserId = getServerData().getInt(Constants.USERMAIL_CREATED_USERID);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return createdUserId;

	}

	/**
	 * This method provides the userDetails updatedDateTime
	 * @return updatedDateTime
	 */
	public String getUserDetails_updatedDateTime() {

		try {
			if(getServerData() != null) {
				updatedDateTime = getServerData().getString(Constants.USERMAIL_UPDATED_DATETIME);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return updatedDateTime;

	}

	/**
	 * This method provides the userDetails updatedUserId
	 * @return updatedUserId
	 */
	public int getUserDetails_updatedUserId() {

		try {
			if(getServerData() != null) {
				updatedUserId = getServerData().getInt(Constants.USERMAIL_UPDATED_USERID);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return updatedUserId;

	}

	/**
	 * This method provides the userDetails updatedUserId
	 * @return deleteFlag
	 */
	public boolean getUserDetails_deleteFlag() {

		try {
			if(getServerData() != null) {
				deleteFlag = getServerData().getBoolean(Constants.USERMAIL_DELETE_FLAG);
			}
		} catch (JSONException e) {
			CoreLog.logErrorMessage("ERROR READING SERVERDATA");
		}
		return deleteFlag;

	}

}

