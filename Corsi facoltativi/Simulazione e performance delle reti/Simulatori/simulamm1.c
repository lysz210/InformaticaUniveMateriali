/* Universita' Ca' Foscari Venezia
 * Corso di Simulazione e performance delle reti
 * Andrea Marin
 * Simplified simulation of M/M/1 queue
 */

#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#include<time.h>



#define Q_LIMIT 100 /*queue capacity*/
#define NUM_MAX_EVENTS 1000000
#define BUSY 1
#define IDLE 0

#define NUMEVENT 2

/*Parameters*/
#define LAMBDA 2.0
#define MU     3.0

double sim_time; /*simulated time*/
int server_status; /*Is the server busy or idle?*/
int num_in_q; /*number of jobs in queue*/
double time_next_event[NUMEVENT]; /*event calendar. position 0 arrivals, position 1 departures*/
int next_event_type; /*type of next event, 0 arrival, 1 departure*/


/*for the statistics*/
double time_last_event; /*epoch of last processed event*/
double area_num_in_q;  /*to compute the expected number of customers*/

/*Sample from exponential distribution*/
double exponential(double rate) {
  return -log(rand()*1.0 / RAND_MAX)/rate;
}

/*Initialize the simulation with empty queue*/
void initialize(void) {
  srand(time(NULL));  /*Not to be done in serious simulations*/
  
  sim_time = 0.0;

  /*model state*/
  server_status = IDLE;
  num_in_q = 0;

  /*statistics*/
  time_last_event = 0.0;
  area_num_in_q = 0.0;

  /*Event list*/
  time_next_event[0] = sim_time + exponential(LAMBDA);
  time_next_event[1] = -1.0; /*negative denotes no event scheduled*/
}


/*Determine next event*/
void timing() {

  int found = 0;
  double min;
  int i;

  for (i=0; i<NUMEVENT; i++)
    if (time_next_event[i] >= 0 && (!found || time_next_event[i] < min)) {
      min = time_next_event[i];
      next_event_type = i;
      found = 1;
    }

  if (!found) {
    printf("Simulation terminated because of empty event list\n");
    exit(1);
  }
  else 
    sim_time = min;
}

/*Handle arrival event*/
void arrival() {
   /*schedule next arrival*/
   time_next_event[0] = sim_time + exponential(LAMBDA);

   if (server_status == BUSY) {
      num_in_q = num_in_q + 1;
      if (num_in_q > Q_LIMIT) {
         printf("Queue overflow\n");
         exit(2);
      }
   }
   else {
      server_status = BUSY;

      /*schedule event for departure*/
      time_next_event[1] = sim_time + exponential(MU);

   }
}  

/*Handle departure*/
void departure() {
   
   if (num_in_q == 0) { /*none in queue!*/
      server_status = IDLE;
      time_next_event[1] = -1.0; /*no further departure*/
   }
   else {
      num_in_q = num_in_q - 1; /*fetch a customer for the queue*/

      /*schedule next departure*/
      time_next_event[1] = sim_time + exponential(MU); 
   }

}


/*Handle statistics*/
void statistics() {
   double delay;

   delay = sim_time - time_last_event;
   time_last_event = sim_time;

   area_num_in_q += num_in_q * delay;
}


int main() {
  int i;

  initialize();

  for (i=0; i<NUM_MAX_EVENTS; i++) {
     
     timing();

     statistics();

     switch(next_event_type) {
        case 0:
           arrival();
           break;
        case 1:
           departure();
           break;
     }
  }

  printf("The expected number of customer is queue is %f \n", area_num_in_q/sim_time);
  return 0;
}
