#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <string.h>
#include <fcntl.h>

#include <event2/event.h>
#include <event2/bufferevent.h>

/**
 * compile:
 * gcc libeve_event_base.c -o libeve_event_base -levent
 */
int main(){
    puts("init a event_base");
    struct event_base *base;
    base = event_base_new();
    const char *x = event_base_get_method(base);
    printf("METHOD: %s\n", x);
    int y = event_base_dispatch(base);
    event_base_free(base);
    return 1;
}