select employees.name as Работник,
vacancy.name as Вакансия,
companies.name as Компания
from employees join info
on employees.id = info.employee_id
join vacancy
on info.vacancy_id = vacancy.id
join companies
on vacancy.companies_id = companies.id
where  vacancy.name ='Бухгалтер'
order by employees.name;

select * from show_employees_who_are_accountants;