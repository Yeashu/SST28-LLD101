How i solved the issues:
In metrics Loader it was creating a new instance everytime :
I implemented getInstance() in merticsRegistry which i now used to get a single instance;
To implement the singleton I use the Holder class approach where i store MetricsRegistry as private static final variable it automatically handles lazyLoading and is safe.
I also implement readResolve() to solve the deserealization issue

These were done in following steps from readme:
Tasks
1) Make `MetricsRegistry` a proper, **thread-safe singleton**
   - **Lazy initialization**
   - **Private constructor**
   - Thread safety: pick one approach (recommended: static holder or double-checked locking)

2) Block reflection-based multiple construction
   - If the constructor is called when an instance already exists, throw an exception
   - (Hint: use a static flag/instance check inside the constructor)

3) Preserve singleton on serialization
   - Implement `readResolve()` so deserialization returns the same singleton instance

4) Update `MetricsLoader` to use the singleton
   - No `new MetricsRegistry()` anywhere in code
