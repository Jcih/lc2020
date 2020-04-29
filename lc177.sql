CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set N = N - 1;
  RETURN (
      
      # Write your MySQL query statement below.
      select distinct Salary 
      from Employee 
      order by salary desc #降序
      limit N, 1 # 跳过N 行， 取1 行数据
  );
END