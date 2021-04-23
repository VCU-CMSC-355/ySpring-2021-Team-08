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
2. If the opcode does not exist in the service file, return a message with a 401 error (Opcode Not Found).
3. If the opcode does exist in the service file,
4. 
