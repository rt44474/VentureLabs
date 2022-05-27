# VentureLabs
 
## Author
- [Tomasz Rafalski] (https://github.com/rt44474)


Task1:

Task1 is located in task1 directory.
About application:
I created two tables user and blog, with relation one to many, so one user can have many blogs but one blog belongs to one user.
There are 5 endpoins:
- list
- login
- new entry
- new user
- delete entry
Everyone can get list of blogs (http://domain/blog).
Also everyone can try to log in (http://domain/blog?action=login&user=admin&password=admin).
To create new blog/new entry(http://domain/blog?action=new&text=testtext) you need to authenticate via HttpBasic.
To create a new user(http://domain/blog?
action=new_user&username=test&password=test&permission=superuser&readonly=yes) you need to authenticate via HttpBasic and have permission superuser.
To delete an blog/entry(http://domain/blog?action=delete&id=1) you need to authenticate via HttpBasic and this entry needs to be yours i.e. 
user_id in blog must be your id.

Applications is using mysql database with name blog.

Task2:

Task2 is located in task2 directory.

If there are any problems/issues please contact me.
