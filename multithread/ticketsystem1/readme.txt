Release Log:
    * 将Consumer线程关闭，只开Producer线程，而且在Producer线程里面自己wait后，自己notify，看能否唤醒他。