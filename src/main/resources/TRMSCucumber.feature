# This is a comment in a Feature File
Feature: TRMS Page links work

  #Each Scenario will connect to a user story
  Scenario: Add Request works
    Given The Guest is on the TRMS Employee Page
    When The Guest clicks Add Request
    Then The Guest should be on the Add Request Page
    
   Scenario: Get Request works
    Given The Guest is on the TRMS Employee Page
    When The Guest clicks Get Request
    Then The Guest should be on the View Request Page
    
    Scenario: Delete Request works
    Given The Guest is on the TRMS Employee Page
    When The Guest clicks Delete Request
    Then The Guest should be on the View Request Page
