# Client-Side Encryption Tool Using AES-256
## Description:
#### Implemented AES-256 Encryption: Utilized a Crypto Library to apply AES-256 encryption on a secret message. AES (Advanced Encryption Standard) is a symmetric block cipher that encrypts data in 128-bit blocks, with key sizes of 128, 192, or 256 bits.
#### Developed Client-Side Interface in Java: Designed and implemented the user interface for the encryption tool using Java. The interface allows users to encrypt and decrypt messages using AES-256.
#### Performed AES-256 Decryption: Applied the Crypto Library to decrypt the encrypted message back into plaintext using the same AES-256 key.

## Code Organization and Documentation: 
Structured the project with a clear directory for the "Encryption Algorithm," including the EncryptionDecryption class as the main executable for running and debugging the program. The AesHelper class handled encryption computations, while the UiHelper class managed the user interface, including panels, labels, and event listeners.

## Technical Highlights:
#### The project demonstrates how Java can effectively convert plaintext into ciphertext and back using a symmetric private key, showcasing practical implementation of encryption/decryption processes in a real-world scenario.


![Screenshot (13)](https://github.com/user-attachments/assets/2ac14431-35d6-43d0-ab6e-cd6634cfeec9)


## Prerequisites:
      Run on IntelliJ  Prerequisites: jdk 22.0.01.
      Features: Crypto Library is being used internally by Java 8 ECB done by default internally by Java CYPHER_ALGORITHM. 
      No need to externally block split the input plain text.
      Key Padding done to 16, 24, 32 bytes depending on user key input using adjustKeyLenght().



Run on IntelliJ

Prerequisites:
jdk 22.0.01

Features:
Crypto Library is being used internally by Java 8
ECB done by default internally by Java CYPHER_ALGORITHM. 
No need to externally block split the input plain text.
Key Padding done to 16, 24, 32 bytes depending on user key input using adjustKeyLenght().
