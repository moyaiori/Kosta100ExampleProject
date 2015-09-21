// 생성자 함수(일상생활의 객체를 추상화)
function Student(name, korean, math, english, science){
	this.name = name;
	this.korean = korean;
	this.math = math;
	this.english = english;
	this.science = science;
	
	this.getSum = function(){
		return this.korean + this.math + english + this.science;
	};
	
	this.getAverage = function(){
		return this.getSum() / 4;
	};
	
	this.toString = function(){
		return this.name + '\t' + this.getSum() + '\t' + this.getAverage();
	};
}