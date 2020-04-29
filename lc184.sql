# Write your MySQL query statement below
select d.Name Department, e.Name Employee, e.Salary from Employee e
join Department d
on e.DepartmentId = d.Id
where e.Salary in (select max(Salary) from Employee e2 where e2.DepartmentId = d.Id);