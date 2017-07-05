# SECURDE-Machine-Project
The Senior High School Department is planning to have their own library. In order to have a smooth reservation system, the SHS Department has decided to set up an online library system which allows the students and faculty members to reserve books or meeting rooms online. With your knowledge in developing secure web applications, the SHS Department anticipates that you will be able to assist them in constructing the SHS Online Library System. The following are the requirements supplied by the SHS Department:

High Level Requirements:
1.	The students and faculty members should have the ability to search for and reserve books, magazines, Thesis and meeting rooms (5 rooms). 

The online library system should display the following details when a student/faculty wants to borrow/reserve a book/magazine:
  •	Location: Used Dewey Decimal System
  •	Author, Publisher, Year
  •	Tags
  •	Status (Out, Reserved or Available)
  •	If borrowed/OUT, display the date of availability
  •	If available, display the reservation date and anticipated return date (student:1week, faculty:1month)

Meanwhile, for the reservation of the 5 Meeting Rooms. The system should display the following:
  •	Availability (Reserved or Available)
  •	Date and Time available (be creative on this part)

2.	In order to borrow/reserve online, student/faculty member must create an account via the registration page. At least the following information must be provided by the customer:
  •	Name (First, Middle Initial, Last)
  •	Username
  •	Password
  •	E-mail Address
  •	Student#/Employee#
  •	Birthday
  •	Secret Question (In case, the user forgets his/her password)

3.	Users can leave reviews only for books/magazines/periodic that they have already borrowed.

4.	Aside from the customer accounts, there are three additional accounts that will be part of the system:
  •	Library Manager - can only edit book information, add new book, delete book and override reservations. In addition, the manager can export to an excel sheet/XML of the status of all books and meeting rooms. 
  •	Library Staff - can only edit book information, add new book, delete book and availability of meeting rooms.
  •	Administrator – can create new Library Manager, Library Staff, Library Student Assistant and accounts and assign temporary passwords, which if not changed within 24 hours, will render the account expired. Also, the administrator can export to an excel sheet/XML file of the status of all books and meeting rooms.

Security Requirements:
1.	All essential activities must be logged for audit purposes.
2.	Authentication, Access Control, Session Management, and Error Handling controls must be correctly implemented.

Software/Programming Language Requirements
1.	JAVA Web Programming

