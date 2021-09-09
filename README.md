# AetnaCodeChallenge

# Android Photo Code Challenge

This code challenge will evaluate your abilities to develop a native Android application.  Please use best coding practices and patterns when building this app.

For this challenge, you will be creating and adding functionality an app for viewing photos. You will utilize the flickr API for photo search and photo details.


------------------------------------------------------------------------------------------------------------------------


## Getting Started

### Pre-Requisites
- Install Android Studio

### API Requirements
- Your application must run on a recent API

------------------------------------------------------------------------------------------------------------------------


## Next Steps

In the Tasks folder there are several tasks to complete. Each folder contains a README describing the task and any other information you might need. Please complete them in order.

**Note1:** Feel free to use outside resources. (e.g. Google, Stack Overflow, Ask us questions, Etc...)

# Task 1: List of photos

Acceptance Criteria:
  1. The search results should come from the API listed above.
  2. A search box and search button should be at the top screen.
  3. A list should be below the items in #2, and should be a grid with 2 columns.
  4. Each item displays the image and title.
  5. The title should be centered under the image.
  6. When performing the search, indicate progress while not blocking the UI.
  7. Make sure to handle state during orientation change
  
  # Task 2: View Photo Details
  Acceptance Criteria:
  1. Update the list view such that clicking a photo from the list will take the user to a photo detail page
 

  For any photo:
  2. The detail view shows the image, title, description, image width, image height, and author
  3. The image should span the entire screen horizontally.
  3. The details listed in #2 should be layout nicely below the image
  4. Make sure to handle state during orientation change
  
  # Task 3: Recent searches
  Acceptance Criteria:
  1. When the user taps the search button, the search term is saved to local storage.  You can use persistance of your choice (e.g. shared preferences, SQLite, etc...)
  2. When the search box is empty, the user will see a list of recent search terms.  Include a "Recent Searches" header above the list.
  3. If there are no searches yet, the screen will show the user the following label: "You have no recent searches.  Enter a search term above." with the header
  4. The recent searches list should have a max of 5 items, with the most recent on top.
  5. If a 6th search is done, remove the oldest term from persistance and save the new term.
  6. Once the user taps on a recent search item, the title and recent search list will disappear and the term will be searched for and show the results as before.
  7. Make sure to handle state during orientation change
  
  # Task 4: Testing
  Acceptance Criteria:
  1. Write a passing unit test which tests any method in your app
  2. Write a passing espresso test which tests any screen of your choice

  # Task 5: Accessibility
  Acceptance Criteria:
  1. Every screen in your app should gracefully handle itself when the font size is bumped up to the largest setting.
  2. When talkback is enabled, every screen should navigate through one item at a time in a logical order.

  
  
  
  




