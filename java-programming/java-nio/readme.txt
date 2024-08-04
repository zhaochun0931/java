Writing to a File:

FileChannel.open(Paths.get(filePath), StandardOpenOption.CREATE, StandardOpenOption.WRITE): Opens a FileChannel to write to a file. If the file does not exist, it is created.
ByteBuffer.allocate(1024): Allocates a ByteBuffer with a capacity of 1024 bytes.
buffer.put(content.getBytes()): Puts the content to be written into the buffer.
buffer.flip(): Prepares the buffer for reading.
fileChannel.write(buffer): Writes the buffer’s contents to the file.







Reading from a File:

FileChannel.open(Paths.get(filePath), StandardOpenOption.READ): Opens a FileChannel to read from a file.
ByteBuffer.allocate(1024): Allocates a ByteBuffer for reading data.
fileChannel.read(buffer): Reads data into the buffer.
buffer.flip(): Prepares the buffer for reading.
sb.append((char) buffer.get()): Appends the characters read from the buffer to a StringBuilder.
