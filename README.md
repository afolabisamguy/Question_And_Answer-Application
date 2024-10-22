# Question and Answer Application

This is a simple **Question and Answer** application for Android. The app presents users with a series of True/False questions, and users need to answer them by selecting either **True** or **False**. Additionally, the app has a **Cheat** button that allows users to see the correct answer, but if they use it, the score is not counted for that question. The app also features **Next** and **Previous** buttons to navigate through the questions.

## Features

- **True/False Questions**: Users answer questions by clicking either the **True** or **False** button.
- **Cheat Button**: Users can click the **Cheat** button to reveal the correct answer, but using it will prevent the question from being scored.
- **Score Tracking**: The app tracks the user's score, but no score is added if the cheat button is used for that question.
- **Navigation**: Users can navigate between questions using the **Next** and **Previous** buttons.

## Screenshots

### Main Screen

The main screen presents the user with a question in the form of a statement. Below the question, the user can see three buttons: **True**, **False**, and **Cheat**. At the bottom, there are **Next** and **Previous** buttons for navigation.

- A typical question is: 
    ```xml
    The Red Sea is part of the Pacific Ocean.
    ```
  
  The user has to determine if the statement is true or false.

### User Interactions

1. **Answering a Question**:
   - When the user clicks **True** or **False**, the app checks if the answer is correct.
   - If the answer is correct, the app gives feedback like "Correct!" and adds to the user's score.
   - If the answer is wrong, it provides feedback such as "Incorrect!"

2. **Cheat Button**:
   - If the user clicks the **Cheat** button, the app will reveal the correct answer for the current question.
   - After cheating, the score for that particular question is not added, regardless of whether the user clicks **True** or **False** afterward.
   
3. **Navigating Between Questions**:
   - The **Next** button moves to the next question in the list.
   - The **Previous** button allows the user to go back to the previous question.
   - Navigation is circular, meaning if the user reaches the last question and clicks **Next**, they will return to the first question. The same applies in reverse for the **Previous** button.

### Score Handling
- The score is updated only when the user answers the question without using the **Cheat** button.
- If the **Cheat** button is clicked, the app disables scoring for that question.

## Setup Instructions

### Prerequisites

- Android Studio (latest version)
- A device or emulator running Android 5.0 (API level 21) or higher

### Steps to Run the Application

1. **Clone the Repository**: 
   
2. **Open the Project in Android Studio**:
   - Launch Android Studio.
   - Select **Open an existing Android Studio project**.
   - Navigate to the folder where the repository was cloned, and open it.

3. **Build and Run**:
   - Ensure that an Android device or emulator is connected.
   - Click **Run** or use the shortcut `Shift + F10` to compile and run the app on the connected device.

### App Components

- **MainActivity**: The primary activity where the questions are displayed and the user interacts with the buttons.
- **Question Model**: A data model that represents a question with a statement and the correct answer.
- **Cheat Logic**: Handles the logic for the cheat functionality, ensuring that the score is not updated if the user cheats.

## Future Enhancements

- **Add more questions** to make the quiz longer and more varied.
- **Timer**: Introduce a timer for each question to increase difficulty.
- **Scoreboard**: Display a final score summary at the end of the quiz.
- **Hints**: Provide an optional hint system for users instead of cheating.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to reach out if you have any issues or feature requests!
