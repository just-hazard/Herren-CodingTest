# 헤렌 코딩테스트

## Query 작성
1. 총점(국어 + 영어 + 수학)이 높은 순으로 이름과 총점, 순위를 출력해주세요.
  ```
  select 
	@curRank := @curRank + 1 AS rank,
	name, 
	sum(score) as total
	from midterm a, (SELECT @curRank := 0) b
	group by name
  ```
2. 각 과목별 최저 점수가 누구인지 이름, 과목, 점수를 출력해주세요.
```
select 
	b.name, 
	a.subject, 
	a.score 
	from (
		select 
			min(score) as score, 
			subject
			from midterm
			group by subject
) a inner join midterm b ON (
	a.subject = b.subject
	and a.score = b.score
)
```
3. 총점이 200 점 넘은 사람은 누구인지 이름, 총점 출력해주세요.
```
select
  t.name,
	t.total
	from (
		select
			name,
			sum(score) as total
			from midterm
			group by name
	) t
	where total >= 200
  ```
4. 늑대의 수학점수가 잘못 입력됐습니다. 수정을 해주세요.
    늑대의 수학점수는 여우와 돼지의 수학점수 평균보다 15점이 더 높습니다.
```
update
	(
	select 
		round(avg(score)) + 15 as score
		from midterm
		where name in ('여우','돼지')
		and subject = '수학'
) a inner join midterm b ON (
	'늑대' = b.name
) set b.score = a.score
where b.subject = '수학'
```

## 기존 예약 테이블이 한 명의 고객만 예약이 가능하게 설계 되어 있다. 기획자가 한명이 아니라 여러 명이 동시에 예약이 가능하게 개발해 달라고 한다. 어떻게 설계를 할 것인가? 자세히 설명해주세요.

기존의 고객과 예약 도메인 관계 매핑이 OneToOne이였다면 기획자의 요구사항에 맞게 테스트 코드를 작성 후 Entity 구조를 OneToMany형태로 리팩토링 합니다.
이 후 OneToOne 형태에 맞게 관리 되었던 DB 데이터를 OneToMany 구조에 맞게 Migration 해줍니다.
