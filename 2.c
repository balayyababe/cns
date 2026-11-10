//AND and XOR each character with 127
#include <stdio.h>

int main() {
    char *str = "Hello world";
    int i;

    printf("AND with 127: ");
    for (i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] & 127);
    }

    printf("\nXOR with 127: ");
    for (i = 0; str[i] != '\0'; i++) {
        printf("%c", str[i] ^ 127);
    }

    printf("\n");
    return 0;
}
