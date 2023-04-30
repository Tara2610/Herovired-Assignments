'''Description - Create a small command-line program in Python to calculate the total invoice amount for the below purchases - 
Book - Introduction to Python Programming : Rs 499.00
Book - Python Libraries Cookbook : Rs. 855.00
Book - Data Science in Python : Rs. 645.00
Taxes and additional charges are described as details - 
GST : 12%
Delivery Charges : Rs. 250.00
'''

Book1_price=499.00
Book2_price=855.00
Book3_price=645.00
Gst=12
Delivery_charges=250.00

Book_1=print("Book - Introduction to python programming : ",Book1_price)
Book_2=print("Book - Python Libraries Cookbook : ",Book2_price)
Book_3=print("Book - Data Science in Python : ",Book3_price)

quantity1=int(input("Number of 'Introduction to python programming'Books : "))
quantity2=int(input("Number of 'Python Libraries Cookbook' Books : "))
quantity3=int(input("Number of 'Data Science in Python' Books : "))

Total_sum=Book1_price*quantity1+Book2_price*quantity2+Book3_price*quantity3
Gst_sum=(Total_sum*Gst)/100
Final_sum=Total_sum+Gst_sum+Delivery_charges

print("Your Total Bill is : ",Final_sum)
print("Thanks for Purchasing! Have a great day!")


'''Description: Write a program in Python to print the number of unique letters in a string. Only new letters from the string should be counted and not duplicates.
Input : string1 = "India"
Output : uniqueLetters = i,n,d,a
Input : string1 = "Dedication"
Output : uniqueLetters = d,e,i,c,a,t,o,n
'''

String=input("String1 = ")
String_lowercase= String.lower()
Remove_whitespaces= String_lowercase.replace(" ","")
String_set = set(Remove_whitespaces)
print("UniqueLetters = ")
for i in String_set:
    print(i)
print("Number of Unique Letters in the string:",len(String_set))
    




