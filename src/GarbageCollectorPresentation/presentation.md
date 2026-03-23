# JAVA GARBAGE COLLECTORS

1. It's the process of reclaiming the runtime unused memory by destroying the unused objects. At any point in time, the heap memory consists of two types of objects (1)_LIVE_ (2)_DEAD_. It is an automatic process and its implementation lives in the JVM. Garbage collection makes Java memory efficient because it removes the unreferenced objects from heap memory and makes free space for new objects.
2. Dereference:
	- By making a reference `null`
	```
	Student student = new Student();
	student = null;
	```

	- By assigning a reference to another
	```
	Student studentOne = new Student();
	Student studentTwo = new Student();
	studentOne = studentTwo; // now the first object referred by studentOne is available for garbage collection
	```

	- By using an anonymous object
	```
	new Student();
	```

---

- ## 3. 3-Phases of Garbage Collection in Java
	- EXAMPLE 
	> [mem loc 1 <sup>(unmarked)</sup>]--[mem loc 2 <sup>(unmarked)</sup>]--[mem loc 3 <sup>(unmarked)</sup>]--[mem loc 4 <sup>(unmarked)</sup>]--[mem loc 4 <sup>(unmarked)</sup>]

	- Mark objects as alive
		- When GC visits an object, it marks it as accessible and thus alive. Every object the garbage collector visits is marked as alive.
		- All the objects which are not reachable from GC Roots are garbage and considered as candidates for garbage collection.
		> [mem loc 1 <sup>(visited)</sup>]--[mem loc 2 <sub>(not reachable)</sub>]--[mem loc 3 <sup>(visited)</sup>]--[mem loc 4 <sup>(visited)</sup>]--[mem loc 4 <sub>(not reachable)</sub>]

	- Sweep dead objects
		- releases the memory fragments which contain these dead objects.
		> [mem loc 1 (visited)]--[mem loc 2 (~~EMPTY~~)]--[mem loc 3 (visited)]--[mem loc 4 (visited)]--[mem loc 4 (~~EMPTY~~)]

	- Compact remaining objects in memory
		- Memory is compacted after the garbage collector deletes the dead objects
		> [mem loc 1 (visited)]--[mem loc 3 (visited)]--[mem loc 4 (visited)]--[mem loc 2 (**EMPTY**)]--[mem loc 4 (**EMPTY**)]

- ## 4. Generational Garbage Collection
	-  Java categorizes objects into generations and performs garbage collection accordingly as per oracle.com, most objects have a very short life.
	- heap memory area in the JVM is divided into three sections
	```
	|--------------------HEAP AREA----------------------------| |----NON_HEAP AREA-----|
	|------------YOUNG GENERATION----------| |-OLD GENERATION-| |-PERMANENT GENERATION-|
	|-EDEN SPACE-| |-----SURVIVOR SPACE----| |----------------| |----------------------|
	|------------| |----S1----| |----S2----| |----------------| |----------------------|
	.....................................................................................
	|<==============MINOR GC==============>| |<===MAJOR GC===>|
	```
	- The Young Generation is further subdivided into
		- EDEN SPACE : all new objects start here, and initial memory is allocated to them
		- FROM SPACE(S1) & TO SPACE(S2) (ALSO KNOWN AS Survivor spaces) : objects are moved here from Eden after surviving one garbage collection cycle.


- ## 5. Minor Garbage Collection Event
	- When `EDEN` space is filled with objects, a Minor GC is performed. All the dead objects are deleted, and all the live objects are moved to one of the survivor spaces. Minor GC also checks the objects in a survivor space, and moves them to the other survivor space.
      - **THE SEQUENCE**
		1. `EDEN` has all objects: This space will contain all the live and dead objects initially
        2. Minor GC occurs: All alive object are **moved** to `S1` Space and dead objects are removed. Hence `S2` and `EDEN` are empty
        3. New objects are created to `EDEN`. But some of the objects in `S1` and `EDEN` are dead
        4. Minor GC occurs: All dead are removed from `EDEN` and `S1` and alive once are moved to `S2`
        5. Next time when the Minor GC occurs everything live from `EDEN` and `S2` are moved to `S1` 
        6. Objects are moved to the `OLD GENERATION` after certain number of garbage collection cycles of moving around the survivor spaces
		>  <ins>KEY TAKEAWAYS:</ins>
		> - one of the survivor spaces(`S1` or `S2`) is ALWAYS empty
		> - cycle in `YOUNG GENERATION` is called MINOR GC


- ## 6. OLD GENERATION (tenured generation)
	- GC cycle in OLD GENERATION is called MAJOR GC
	- Objects starts in the young generation and eventually ends up in the tenured\old generation if it survives long enough.

><ins>KEY TAKEAWAY:</ins>
>- Since Java uses generational garbage collection, the more garbage collection events an object survives, the further it gets promoted in the heap. It starts in the young generation and eventually ends up in the tenured generation if it survives long enough.
>
><ins>NOTE:</ins>
>- You can use the `-Xmn` flag to set the size of the Young Generation.
>- You can use the `-Xms` and `-Xmx` flags to set the size of the initial and maximum size of the Heap memory.

- ## 7. PERMANENT GENERATION
	- Stores classes and methods, populated by the JVM at runtime based on classes in use
    - PermGen had an upper limit to how much memory it would use to store objects which caused the `out-of-memory` exceptions. This was resolved with Java 8 where PermGen was replaced with MetaSpace which had the ability to resize the heap space as required 
>  <ins>NOTE:</ins>
>- You can use the `-XX:PermGen` and `-XX:MaxPermGen` flags to set the initial and maximum size of the Permanent Generation.

- ## 8. Types of Garbage Collectors
	- ### Serial GC : JVM argument `-XX:+UseSerialGC`
		- simplest implementation of GC and is designed for small applications running on single-thread
        - garbage collection events are conducted serially in one thread and compaction is executed after each garbage collection
        - _CONS_
          - causes “stop the world” events. Entire application is frozen during garbage collection
          - not recommended for low latency applications

	- ### (_default implementation_) Parallel GC (Throughput Collector) : JVM argument `-XX:+UseParallelGC`
      - Suitable for multiprocessor or multithreaded hardware with medium-sized to large-sized data sets
      - Multiple threads are used for minor garbage collection in the Young Generation. A single thread is used for major garbage collection in the Old Generation. 
	  - _CONS_
		  - entire application is frozen during garbage collection
          - recommended to be used when a lot of work needs to be done and long pauses are acceptable, for example running a batch job.
        
	- ### Parallel Old GC  : JVM argument `-XX:+UseParallelOldGC`
      - This is the default version of Parallel GC since Java 7u4. 
      - it uses multiple threads for **BOTH** Young Generation and Old Generation. 

	- ### CMS (Concurrent Mark Sweep) GC (concurrent low pause collector) : JVM argument `-XX:+UseConcMarkSweepGC`
      - it uses multiple threads for **BOTH** Young Generation and Old Generation.
      - runs concurrently alongside application processes
      - _PROS_
        - minimize “stop the world” events. 
      - _CONS_
        - uses more CPU than other GCs. More CPU allocation leads to better garbage collection
        - No compaction is performed in CMS GC. 
      
	- ### G1 (Garbage First) GC : JVM argument `-XX:+UseG1GC`
      - was intended as a replacement for CMS and was designed for multi-threaded applications that have a large heap size greater than 4GB
      - it works in parallel and concurrent like CMS but with a different implementation
      - it has flexible size for YOUNG GENERATION and both YOUNG GENERATION and OLD GENERATION have separate regions.
      - it partitions heap into a set of equal size regions(1MB to 32MB – depending on the size of the heap) and uses thread to scan them
      - After each mark phase G1 knows which regions contains most garbage. Depending on the users preference, G1 can choose to clean few regions OR if longer pause times are acceptable then choose to include more regions.
	  - _PROS_
		  - Application pause duration for memory reclamation is controllable
          - Usually lowest CPU overhead than Shenandoah and ZGC
      - _CONS_
        - still causes "stop the world” during heavy cleaning

	- ### Epsilon Garbage Collector : JVM argument `-XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC`
      - recommended ONLY where developers know the application memory footprint exactly, or even have (almost) completely garbage-free applications which are ultra-latency-sensitive
      - its ONLY job is memory allocation and it does not implement memory reclamation.
      - JVM shutsdown as Java heap is exhausted
      - _CONS_
        - only usable in some cases

	- ### Shenandoah : JVM argument `-XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC`
      - garbage collection cycle work concurrently with the application threads allowing it to work with live objects. This allows it to clean garbage, and release RAM back to the OS almost immediately.
      - _PROS_
        - resolves "stop the world” issue
      - _CONS_
        - More CPU intensive than G1
   
	- ### ZGC : JVM argument  `-XX:+UnlockExperimentalVMOptions -XX:+UseZGC`
      - Similar to Shenandoah, ZGC runs in the background too and works without pausing the application
      - However, this GC is only recommended for applications which require low latency (less than 10 ms pauses) and/or use a very large heap (multi-terabytes).
      - It divides the heap into small chunks of memory. 
      - It starts by finishes the marking dead objects phase within 1ms. Then it moves objects (including the live one too) in the background to a different chunk and then updates the metadata of pointer of the moved object.
      - Any region that contains no live objects is reclaimed immediately
      - _PROS_
        - region‑based approach avoids scanning the entire heap.
        - Uses tiny pauses (typically within 2ms)
        - lower CPU usage

---

- ## 9. So which is the Right Garbage Collector?
  - Most of the time, just run your application and allow the JVM to select the right collector. If the performance still doesn't meet your goals, you can modify the collector as per your application requirements.
	- **SERIAL**: 
         - has small data set
         - run on a single processor
         - has no pause time requirements

    - **PARALLEL**: 
        - must run at peak performance
        - pauses of one second or longer are acceptable
     
	- **CMS/G1**
      - If response time is more important
      - garbage collection pauses must be less than 1s

	- **ZGC** 
      - If response time is a high priority, and/or you are using a very large heap

>  <ins>KEY TAKEAWAYS:</ins>
>	- Avoid Manual Triggers: GC can be triggered with `System.gc()` or `Runtime.gc()` but they provide no guarantee that the garbage collector will actually run.














