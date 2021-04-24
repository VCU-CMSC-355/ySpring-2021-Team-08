Module: Service Broker

Component: Service Broker


| Inputs | Process | Output |
| --- | --- | --- |
| Instruction | Calls the translator, message, and tax calculator modules based upon the entered-in instruction. | ReturnCode |
| | | ReturnData |

Input: 
* Instruction - formatted as "OPCODE,args"

Output: 
* ReturnCode and ReturnData - formatted as "ReturnCode,ReturnData"

Author: Haley Currence

Version Date: 4/21/2021 CMSC 355 - Spring 2021

Notes:
* Accepted Opcodes:
  * TRANSLATE
  * TAX
  * MESSAGE

Pseudocode:
1. Parse the opcode from the instruction. 
2. Search for the opcode in the service file.
3. If the opcode does not exist in the service file, return a message with a 401 error (Opcode Not Found). Set the return code to 4.
4. If the opcode does exist in the service file:
  4. Parse the arguments from the instruction. 
  4. Call the module associated with the opcode and pass in the instruction's arguments as arguments.
    4. If that module could not be called, return a message with a 408 error (Module Not Found). Set the return code to 4.
  4. Store that modules return data. Set the return code to 0.
5. Return the return code and the return data.


Haley's Notes:
* Need to check if arguments are null.
