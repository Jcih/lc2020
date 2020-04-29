# Write your MySQL query statement below
select d.name as Department, e.Name as Employee, e.Salary from Department d, Employee e
where d.Id = e.DepartmentId and (  
    Select count(distinct Salary) From Employee where DepartmentId=d.Id and Salary > e.Salary  
)<3  
order by Department;  