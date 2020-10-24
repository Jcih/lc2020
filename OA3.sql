-- Eversight OA 3
select p.id, p.title, sum(r.number_of_tickets) as reserved_tickets 
from play p
left join reservations r
where p.id = r.play_id
group by p.id
order by sum(r.number_of_tickets) DESC, p.id ASC;