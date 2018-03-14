package edu.wou.jmozingo12.barfly.data;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "barfly-mobilehub-268674183-Breweries")

public class BreweriesDO {
    private String _userId;
    private String _breweryName;
    private String _breweryLocation;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBRangeKey(attributeName = "BreweryName")
    @DynamoDBIndexHashKey(attributeName = "BreweryName", globalSecondaryIndexName = "BreweryName-BreweryLocation")
    public String getBreweryName() {
        return _breweryName;
    }

    public void setBreweryName(final String _breweryName) {
        this._breweryName = _breweryName;
    }
    @DynamoDBIndexRangeKey(attributeName = "BreweryLocation", globalSecondaryIndexName = "BreweryName-BreweryLocation")
    public String getBreweryLocation() {
        return _breweryLocation;
    }

    public void setBreweryLocation(final String _breweryLocation) {
        this._breweryLocation = _breweryLocation;
    }

}
