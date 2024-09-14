select * 
from (
select aa.*
from (select a.city, length(a.city) l
from station a
order by length(a.city) desc, a.city asc) aa
where rownum=1
union all
select bb.*
from (select b.city, length(b.city) l
from station b
order by length(b.city) asc, b.city asc) bb
where rownum=1)
order by l asc;


select name || '('||substr(occupation,0,1)||')'
from occupations
order by name;
select 'There are a total of '||count(occupation)||' ' ||lower(occupation)||'s.'
from occupations
group by occupation
order by count(occupation), occupation;


select n,'Root'
from bst
where p is null
union
select n,'Leaf'
from bst a
where a.p is not null and not exists (select 1 from bst b where b.p=a.n)
union
select n,'Inner'
from bst a
where a.p is not null and exists (select 1 from bst b where b.p=a.n)
order by 1;


select distinct city
from station
where substr(lower(city),1,1) in ('a','i','u','e','o')
and substr(lower(city),length(city)) in ('a','i','u','e','o');

select (select count(a.city) from station a)-(select count(distinct b.city) from station b)
from dual;


select c.company_code,c.founder
,(select count(distinct lm.lead_manager_code) from lead_manager lm where lm.company_code=c.company_code ) lm
,(select count(distinct sm.senior_manager_code) from senior_manager sm where sm.company_code=c.company_code ) sm
,(select count(distinct m.manager_code) from manager m where m.company_code=c.company_code ) sm
,(select count(distinct e.employee_code) from employee e where e.company_code=c.company_code ) e
from company c
order by 1;


select 
CASE
    WHEN A+B<=C OR B+C<=A OR C+A<=B THEN 'Not A Triangle'
    WHEN a=b and a=c and b=c THEN 'Equilateral'
    WHEN a=b or a=c or b=c THEN 'Isosceles'
    else 'Scalene'
END as t
from triangles;

select round(power(power(max(lat_n)-min(lat_n),2)+power(max(long_w)-min(long_w),2),0.5),4) b
from station;

select 
--min(lat_n),max(lat_n),min(long_w),max(long_w),
--abs(max(lat_n)-min(lat_n)),
--abs(max(long_w)-min(long_w)),
round(
    abs(max(lat_n)-min(lat_n))+
    abs(max(long_w)-min(long_w))
    ,4)
from station;

select round(median(lat_n),4)
from station;

select avg(population)
from city
where district='California';

select round(avg(population))
from city;


select sum(population)
from city
where COUNTRYCODE = 'JPN';

select 
--a, 
--round(a),
ceil(a) --round it up to the next integer
from(select avg(salary)-avg(to_number(REPLACE(TO_CHAR(salary),'0',''))) a
from EMPLOYEES);

select earnings, count(employee_id)
from (
select 
a.employee_id,
max(a.months*a.salary) earnings
from Employee a
group by employee_id) aa
where aa.earnings=(select max(b.months*b.salary) from Employee b)
group by earnings;

SELECT (MONTHS * SALARY) E , COUNT(*) 
FROM EMPLOYEE 
where (MONTHS * SALARY) = (select max(b.months*b.salary) from Employee b)
GROUP BY MONTHS,  SALARY
ORDER BY 1 DESC ;

select *
from  (SELECT (MONTHS * SALARY) E , COUNT(*) 
FROM EMPLOYEE 
GROUP BY MONTHS,  SALARY
ORDER BY 1 DESC)
where ROWNUM <= 1;

select round(sum(lat_n),2),round(sum(long_w),2)
from station;

select round(sum(lat_n),4)
from station
where lat_n between 38.7880 and 137.2345;

select round(max(lat_n),4)
from station
where lat_n < 137.2345;

select round(long_w,4)
from station
where lat_n = (
select max(lat_n)
from station
where lat_n < 137.2345
);

select round(min(lat_n),4)
from station
where lat_n > 38.7880;

select round(long_w,4)
from station
where lat_n = (
select min(lat_n)
from station
where lat_n > 38.7880
);

select 
CASE WHEN grade > 7 THEN st.name ELSE null END name
, s.grade
, st.marks
from students st, grades s
where 1=1
and st.marks between s.min_mark and s.max_mark
order by s.grade desc, st.name asc;

select 
s.hacker_id||' '||h.name
--,count(s.challenge_id) c
from submissions s, challenges c, difficulty d, hackers h
where 1=1
and s.challenge_id=c.challenge_id
and c.difficulty_level=d.difficulty_level
and s.score=d.score
and s.hacker_id=h.hacker_id
group by s.hacker_id,h.name
having count(s.challenge_id)>1
order by count(s.challenge_id) desc, s.hacker_id asc;

select 
(select wx.id from wands wx where wx.code=x.code and wx.power=x.p and wx.coins_needed=x.cd ) id,
age,cd,p
from (
select w.code,wp.age,w.power p, min(w.coins_needed) cd
from wands w, wands_property wp
where w.code=wp.code
and wp.is_evil=0
group by w.code,wp.age, w.power) x
order by p desc, age desc
;

SELECT aa.ID, aa.AGE, aa.COINS_NEEDED, aa.PW 
from (
SELECT 
A.id
, A.code
, B.AGE
, ROW_NUMBER() OVER(PARTITION BY A.power, B.age ORDER BY A.coins_needed) RN
, A.coins_needed
, A.power PW 
FROM Wands A, Wands_Property B 
WHERE 1=1
and A.code = B.code 
and B.is_evil = 0
ORDER BY A.power DESC, B.age DESC) aa
where aa.rn=1;


select h.hacker_id, h.name, count(c.challenge_id) cnt
from hackers h, challenges c
where h.hacker_id=c.hacker_id
group by h.hacker_id, h.name
having count(c.challenge_id) in (
    select ccc.cnt_challenge
    from(
        select cc.cnt_challenge,count(cc.hacker_id) cnt_hacker
        from(
            select c.hacker_id, count(c.challenge_id) cnt_challenge
            from challenges c
            group by c.hacker_id
        ) cc
    group by cc.cnt_challenge
    order by 1 desc, 2 asc) ccc
    where ccc.cnt_hacker=1 or rownum=1
)
order by 3 desc, 1 asc;

--https://stackoverflow.com/questions/11116275/increment-row-number-on-group
select hacker_id, name, sum(max_score) score
from(
    select h.hacker_id, h.name, s.challenge_id, s.submission_id
    ,max(s.score) OVER (PARTITION BY s.hacker_id, s.challenge_id) max_score
    ,ROW_NUMBER() OVER(PARTITION BY s.hacker_id, s.challenge_id ORDER BY s.score desc) RN
    ,DENSE_RANK() OVER(PARTITION BY s.hacker_id, s.challenge_id ORDER BY s.score desc, s.submission_id desc) DN
    from hackers h, submissions s
    where h.hacker_id=s.hacker_id and  s.score > 0)
where rn=1
group by hacker_id, name
having sum(max_score)>0
order by 3 desc, 1 asc; 

select ct.continent, floor(avg(c.population))
from city c, country ct
where 1=1
and c.countrycode=ct.code
group by ct.continent;


select root, end_Date 
from(
SELECT task_id, start_Date, end_Date
,CONNECT_BY_ROOT start_date as root
,level as duration 
FROM projects 
WHERE CONNECT_BY_ISLEAF = 1
CONNECT BY PRIOR end_date = start_date
--start with task_id = 1
)
where 1=1
and root not in (select end_Date from projects)
ORDER BY duration, root;


select s.name
--,s.id, s.name, p.salary, f.friend_id, fs.name friend_name, fp.salary
from friends f, Students s, students fs, packages p, packages fp
where 1=1
and s.id=f.id
and fs.id=f.friend_id
and s.id=p.id
and f.friend_id=fp.id
and fp.salary > p.salary
order by fp.salary asc;

select distinct f1.x,f1.y
from (select rowid r,x,y from functions) f1, (select rowid r,x,y from functions) f2
where f1.x=f2.y and f1.y=f2.x and f1.r!=f2.r and f1.x<=f1.y
order by f1.x,f1.y;


select c.contest_id, c.hacker_id, c.name
, sum(s.total_submissions)
, sum(s.total_accepted_submissions)
, sum(v.total_views)
, sum(v.total_unique_views)
from Contests c, 
Colleges cl, 
Challenges ch, 
(select challenge_id, sum(total_views) total_views, sum(total_unique_views) total_unique_views from view_stats group by challenge_id) v, 
(select challenge_id, sum(total_submissions) total_submissions, sum(total_accepted_submissions) total_accepted_submissions from submission_stats group by challenge_id) s
where 1=1
and c.contest_id=cl.contest_id(+)
and cl.college_id=ch.college_id(+)
and ch.challenge_id=v.challenge_id(+)
and ch.challenge_id=s.challenge_id(+)
group by c.contest_id, c.hacker_id, c.name
having sum(s.total_submissions)!=0 or sum(s.total_accepted_submissions)!=0 or sum(v.total_views)!=0 or sum(v.total_unique_views)!=0
order by 1;


select sss.submission_date, cs.Unique_Count, sss.hacker_id, sss.name
from (
    select ss.*
    ,ROW_NUMBER() OVER(PARTITION BY ss.submission_date ORDER BY ss.count_hacker desc, ss.hacker_id asc) RN
    from (
        select s.submission_date
        ,s.hacker_id
        ,h.name
        ,count(s.submission_id) OVER (PARTITION BY s.submission_date, s.hacker_id) count_hacker
        from Submissions s, hackers h
        where 1=1
        and s.hacker_id=h.hacker_id
        --and s.submission_date=to_date('2016-03-01')
    ) ss
) sss, 
(
SELECT submission_date, 
COUNT(DISTINCT hacker_id) Unique_Count 
FROM (
     SELECT a.submission_date, 
     v.hacker_id, 
     COUNT(DISTINCT v.submission_date) cnt 
     FROM (SELECT DISTINCT submission_date 
         FROM Submissions 
         ORDER BY 1 ) A, submissions v 
     WHERE v.submission_date <= a.submission_date 
     GROUP BY a.submission_date, v.hacker_id) 
WHERE TO_CHAR(submission_date,'DD') = cnt 
GROUP BY submission_date) cs
where 1=1
and sss.rn=1
and cs.submission_date = sss.submission_date
order by 1 asc;

--select listagg(p, '&' ) within group (order by p) from (SELECT LEVEL + 1 p FROM dual CONNECT BY LEVEL < 1000);

--event
select p from (SELECT LEVEL p FROM dual CONNECT BY LEVEL < 1000)
where mod(p,2)=0;

--odd
select p from (SELECT LEVEL p FROM dual CONNECT BY LEVEL < 1000)
where mod(p,2)!=0;

--prime
select *
from (select p from (SELECT LEVEL+1 p FROM dual CONNECT BY LEVEL < 1000) p1
WHERE NOT EXISTS (
    SELECT NULL
    FROM (SELECT LEVEL + 1 p FROM dual CONNECT BY LEVEL < 1000) p2
    WHERE p2.p < p1.p
    AND MOD(p1.p, p2.p) = 0)
);

select listagg(p, '&' ) within group (order by p)
from (select p from (SELECT LEVEL+1 p FROM dual CONNECT BY LEVEL < 1000) p1
WHERE NOT EXISTS (
    SELECT NULL
    FROM (SELECT LEVEL + 1 p FROM dual CONNECT BY LEVEL < 1000) p2
    WHERE p2.p < p1.p
    AND MOD(p1.p, p2.p) = 0)
);

select rpad(' ',r*2,' ')||rpad('* ',l*2,'* ') k 
from ( 
    select level l
    , row_number() over(order by null) r 
    from dual 
    connect by level <= 20 
    order by l desc
);

