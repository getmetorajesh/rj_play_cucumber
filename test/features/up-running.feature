Feature: Application is up and running

	Check if the app is up and runs with cucumber integration

	Scenario: Seeing if the app is running
		Given my application running
		When I go to the "start" page
		Then I should see "Hello world!"

	Scenario: Count controller
		Given the page is countcontroller
		When I visit the "count" page
		Then I should see count	