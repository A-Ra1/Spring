package com.sist.manager;

/*
"thumbUrl":"/common/mast/movie/2020/10/thumb/thn_4ba51ba9b5f3439ca3d036f6391d58ba.jpg",
"movieNm":"도굴",
"movieNmEn":"Collectors",
"synop":
"showTm":"114",
"director":"박정배",
"prNm":"(주)싸이런픽쳐스",
"dtNm":"씨제이이앤엠(주)",
"repNationCd":"한국",
"movieType":"장편",
"moviePrdtStat":"개봉예정",
"genre":"범죄",
"watchGradeNm":"12세이상관람가",
"openDt":"20201104",
"rank":1,
"rankInten":0,
 */
public class MovieVO {

	private int mno;
	private int rank;
	private String title_ko;
	private String title_en;
	private String poster;
	private String director;
	private String genre;
	private String grade;
	private String regdate;
	private String nation;
	private String time;
	private String story;
	private int rank_id; // increment, decrement
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle_ko() {
		return title_ko;
	}
	public void setTitle_ko(String title_ko) {
		this.title_ko = title_ko;
	}
	public String getTitle_en() {
		return title_en;
	}
	public void setTitle_en(String title_en) {
		this.title_en = title_en;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public int getRank_id() {
		return rank_id;
	}
	public void setRank_id(int rank_id) {
		this.rank_id = rank_id;
	}
	
}
