@wip_kirich @db
Feature: As a student, I should be able to borrow a book

Scenario: Students borrow new books
Given I login as a student
And I navigate to "Books" page
And I search book name called "Head First Java" k
When I click Borrow Book k
Then verify that book is shown in "Borrowing Books" page k
And verify logged student has same book in database k

