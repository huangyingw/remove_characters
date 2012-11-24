public class RemoveAllDuplicate {
	public void setNthBit(char[] a, int pos) {
		/*
		 * quotient gives us the cell number in the array which needs to be
		 * manipulated. Remember array is zero based, so no need to do
		 * quotient+1.
		 */
		int quotient = pos / 8;
		int remainder = pos % 8;
		a[quotient] |= 1 << (7 - remainder);
	}

	int isNthBitSet(char[] a, int pos) {
		int quotient = pos / 8;
		int remainder = pos % 8;
		/*
		 * 7 - remainder does the trick and ensures that bit in question becomes
		 * least significant bit
		 */
		return ((a[quotient] >> (7 - remainder)) & (0x1));
	}

	void removeAllDuplicates(char[] str)
	{
	    if (!str[0])
	        return;
	    //Initialize the array with all zeroes
	    char hash[32] = {0};
	    int emptySlot = -1;
	    for (int i = 0; str[i] != '\0'; ++i)
	    {
	        if (isNthBitSet(hash, str[i]))
	        {
	            if (emptySlot == -1)
	            {
	                emptySlot = i;
	            }
	        }
	        else
	        {
	            if (emptySlot != -1)
	            {
	                str[emptySlot++] = str[i];
	            }
	            setNthBit(hash, str[i]);
	        }
	    }
	    if (emptySlot != -1)
	        str[emptySlot] = '\0';
	    return;
	}
}
