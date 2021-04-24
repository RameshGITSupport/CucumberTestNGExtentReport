Feature: Page Element validation on DemoQA
	Background: User is on demoQA home page
	Given user is on demoQA Home Page

	@TestCase1
	Scenario: Validate radio button on demoQA
		Given user navigates to radio button page
		When user click on Yes radio
		Then validate yes radio is selected

	@TestCase2
	Scenario: Validate title on demoUAT Page
		Given user navigates to demoUAT Page
		Then verify the title