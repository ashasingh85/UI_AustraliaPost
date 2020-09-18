Feature: Validate the postage cost and delivery times


Scenario: Verify the cost without parcel specification
Given User is on Australia post Landing page
When User enters source and destination post code
Then Two parcel options along with the cost are displayed


Scenario: Verify the cost with parcel specification
Given User is on Australia post Landing page
When User enters source and destination post code
And Select the size weight and delivery date
Then Two parcel options along with the cost are displayed