# uni-java-tasks

==== For English scroll down == 

7.
Используя сервлеты и БД MySQL, создать Web приложение, которое запрашивает
у клиента имя и пароль (должны передаваться на сервер в шифрованном виде),
затем отображает список файлов, которые клиент может загрузить, при этом
каждому зарегистрированному клиенту могут отображаться различные списки
файлов. Параметры авторизации хранить в сессии. Для работы с БД
использовать JDBC.

10.
Реализуйте в классе LinkedList интерфейс Cloneable и разработайте метод clone,
возвращающий новый список со ссылками на те же значения, какие хранятся в
исходном списке, но не выполняющий клонирования значений. Другими
словами, следует обеспечить такое поведение класса, когда модификация
структуры одного списка не влияет на другой список, но изменения,
непосредственно затрагивающие хранимые объекты, "видны" из обоих списков.

16.
Напишите метод, принимающий в качестве параметра ссылку на объект группы
потоков и создающий поток, который периодически выводит на экран данные об
иерархии потоков и подгрупп потоков внутри заданной группы. Протестируйте
метод в составе программы, использующей несколько непродолжительных по
времени выполнения потоков, которые принадлежат различным группам.

17.
Используя механизм рефлексии, напишите программу, которая выводит на экран
полное описание класса с заданным именем, включающее всю информацию о
классе за исключением инструкций импорта, комментариев и кода
инициализаторов, конструкторов и методов.

26.
Создать классы пользовательских тегов, формирующих нужное количество
элементов (строк, ячеек и др.) для размещения результатов выполнения запроса.
В базе данных хранятся координаты конечного множества точек плоскости.
Пользователем вводятся координаты центра и радиусы 5 концентрических
окружностей. Между какими окружностями (1 и 2, 2 и 3, ..., 4 и 5) больше всего
точек заданного множества? Полученное множество точек возвратить клиенту.


======================

7.
Using servlets and MySQL RDBMS, create Web application which promps a client for username and password (must be passed encoded when being passe to the server), then displays the list of files, which a client can download. Different clients may see different lists of files. Authorization parameters must be stored in the session. Use JDBC for working with DB.

10
Implement Cloneable Interface in LinkedList class and method clone that returns new list with the same references without copying values. In other words, modification of the structure of the list doesn't affect the other list, but changes of stored objects can be 'seen' from both lists.

16.
Implement a method which takes a reference to object of ThreadGroup as input and creates a thread which periodically displays data about thread and thread subgroup hierarchy inside of teh given group. Test the method as part of a program that uses several threads with short runtime that belong to different groups. 

17.
Using reflexion write a program that displays full description of the class with given name including all information about the class except for imports, comments and code of constructors, initializators and methods.

26.
Create classes of user defined tags that form necessary number of elements (rows, cells etc.) for placing results of query execurion. There are coordinates of finite set of points (x, y) that are stored in the db. User enters coordinates of the center of the circle as well as radiuses of 5 circles with a common center. Between which circles are there the most number of points from the given set. These points should be returned to the client. 
