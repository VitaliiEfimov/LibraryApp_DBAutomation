Feature: As a data consumer, I want UI and DB book information are match.
@wip_nadya@db
  Scenario: Verify book information with DB
    Given I login as a librarian
    And I navigate to "Books" page n
    When I open book "Chordeiles minor"
    Then book information must match the Database