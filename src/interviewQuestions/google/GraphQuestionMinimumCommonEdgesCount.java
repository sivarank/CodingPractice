package interviewQuestions.google;
/*
Find minimum path count from A to D and B to D. If there is common edge, count it as only once 
 
 A->X->Y->Z->C->D
       ^
       |
       B
{{A,X}{X,Y}{Y,Z}{Z,C}{C,D}{B,Y}} = 6

       
A->M->D<-N<-B

  {{A,M}{M,D}{B,N}{N,D}} = 4 this is the answer
 
 */

/*
  A->X,M
  B->Y,N
  X->Y
  Y->Z
  Z->C
  C->D
  M->D
  N->D
 */
public class GraphQuestionMinimumCommonEdgesCount {

	public static void main(String[] args) {

	}

}
