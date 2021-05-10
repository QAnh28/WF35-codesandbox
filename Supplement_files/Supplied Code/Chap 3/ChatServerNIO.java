	public static void broadcastMessage(String chatName,
											ByteBuffer buffer)
	{
		String messagePrefix = chatName + ": ";
		byte[] messagePrefixBytes = messagePrefix.getBytes();
		final byte[] CR = "\n".getBytes();	//Carriage return.

		try
		{
			int messageSize = buffer.position();
			byte[] messageBytes = buffer.array();
			byte[] messageBytesCopy = new byte[messageSize];

			for (int i=0; i<messageSize; i++)
			{
				messageBytesCopy[i] = messageBytes[i];
			}

			buffer.clear();

			//Concatenate message text onto message prefix...
			buffer.put(messagePrefixBytes);
			for (int i=0; i<messageSize; i++)
			{
				buffer.put(messageBytesCopy[i]);
			}
			buffer.put(CR);

			SocketChannel chatSocketChannel;

			for (ChatUser chatUser:allUsers)
			{
				chatSocketChannel = chatUser.getSocketChannel();
				buffer.flip();

				//Write full message (with user's name)...
				chatSocketChannel.write(buffer);
			}
		}
		catch (IOException ioEx)
		{
			ioEx.printStackTrace();
		}
	}
