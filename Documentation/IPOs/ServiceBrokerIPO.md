Module: Service Broker
Component: Service Broker
 
Function: Calls the translator, message, and tax calculator modules based upon the entered-in instruction.

| Inputs | Process | Output |
| --- | --- | --- |
| Instruction | Calls the translator, message, and tax calculator modules based upon the entered-in instruction. | ReturnCode |
| | | ReturnData |

Input: 
		Instruction - formatted as "OPCODE,args"
Output: 
		ReturnCode and ReturnData - formatted as "ReturnCode,ReturnData"

Author: Haley Currence
Version Date: 4/21/2021 CMSC 355 - Spring 2021