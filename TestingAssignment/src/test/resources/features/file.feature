Feature: API

Scenario: InputOneItem
Given I choose "API" 
When I input "BarackObama"
When I search
Then I should get High number of tweets(5) 


Scenario: InputLowerOfTweets
Given I choose "API" 
When I input "ZvetlanaBajada"
When I search
Then I should get Low number of tweets(0)

Scenario: InputEmpty
Given I choose "API" 
When I input ""
When I search
Then I should get false

Scenario: Inputnull
Given I choose "API"
When I input 
Then I should get false

Scenario: FileInputnull
Given I choose "file"  
When I input
Then I should get false

Scenario: configurationParametersTrue
Given I choose "API" 
When I input "ZvetlanaBajada" 
When I search
Then I should get true

Scenario: ReadAValidFile
Given I choose "file"
When I input "src/test/resources/file.log"
When I search
Then I should get WARNING

Scenario: ReadAInvalidFile
Given I choose "file"
When I input "src/test/resources/filexxx.log"
When I search
Then I should get Invalid file

Scenario: FileInputEmpty
Given I choose "file" 
When I input "" 
When I search
Then I should get false


Scenario: configurationParametersTrueForFile
Given I choose "file" 
When I input "src/test/resources/file.log"
When I search
Then I should get true
