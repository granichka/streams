package local.nix.streams.util;

import java.math.BigInteger;

public class NumberUtil {

    public static boolean IsSimple(BigInteger value)

    {
        for (int i = 2; i < value.intValue(); i++)
        {
            if (value.intValue() % i == 0)
            {
                return false;
            }
        }

        return true;
    }
}
