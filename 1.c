//XOR each character with 0
#include <stdio.h>

int main() {
    char *str = "Hello world";
    int i;

    printf("Original string: %s\n", str);
    printf("After XOR with 0: ");

    for (i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] ^ 0);
    }

    printf("\n");
    return 0;
}
