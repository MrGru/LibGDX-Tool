package com.md.crypto;

public class XorEncrypto {
	public static byte[] encrypt(byte[] bytes, int key) {
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (bytes[i] ^ key);
		}
		return bytes;
	}

	public static byte[] decryp(byte[] bytes, int key) {
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (bytes[i] ^ key);
		}
		return bytes;
	}
}
