## Producteur Consommateur, coded by Bennia Karim

This project implements a simulation of a factory, warehouse, and clients synchronized using semaphores. 

**Objectives**:

* Simulate a factory producing random goods. 
* Simulate a warehouse storing these goods and notifying the factory when the stock is full or empty. 
* Simulate clients withdrawing goods from the warehouse and waiting if it is empty. ‍⏳
* Adjust the production rate based on the number of clients to keep the factory running continuously. 

**How it works**:

1. The factory continuously produces random goods. ➡️
2. If the stock is full, the factory is blocked by a semaphore until the warehouse releases it. 
3. The warehouse accepts the goods from the factory and stores them. ➕️
4. If the stock falls below a minimum threshold, the warehouse wakes up the factory. ➡️
5. Clients withdraw goods from the warehouse. ‍➡️
6. If the warehouse is empty, the client is blocked until new goods arrive. ⏳➡️

**Main classes**:

* **Factory**: Produces goods continuously and communicates with the warehouse. 
* **Warehouse**: Stores goods, manages thresholds, and communicates with the factory and clients. 
* **Client**: Withdraws goods from the warehouse and waits if it is empty. ‍⏳

**Possible enhancements**:

* Limit the maximum production of the factory. ⚠️ DONE
* Limit the storage capacity of the warehouse. ⚠️  DONE
* Mechanism that modifies factory rythm depending on the number of clients.. ⚠️  NOT DONE

**Execution instructions**:

1. Compile the Java files. 
2. Run the `Main` class. 


**License**:

This code is provided under the MIT license. You are free to use, modify, and redistribute it under the terms of the license.

**Feel free to contact me if you have any questions or suggestions!** ✉️
