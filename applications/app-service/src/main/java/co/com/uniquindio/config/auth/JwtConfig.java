package co.com.uniquindio.config.auth;

public class JwtConfig {

    public static final String RSA_PUBLICA = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEogIBAAKCAQEA57xoXe5pV6ck+htg0rfYZ+qFjZr5pUl8jH6Ls/LmyC39XSKZ\n" +
            "4LMq4b2yX2ZNfUC1wh3tMZ7r0XCAJojD1Rau+naRjNE8CT/lfcj+L7u1My9DVtoH\n" +
            "zvZrNN7FesjwaGGG6M5mgBWZD+cbBCgjyyBHn20kjqVQ6AijWshRUUNGivL/6Q+/\n" +
            "q16LpCbvv2SuxWD7jZPelZDSoWvh2WT8G/+8XB4MWt3qiMiSVrRDsBPVpSZQ63HR\n" +
            "tlblYdfLemfzroFgjav+FGnbjHj78Q7EsnTUfiRNonKSOkLBmqYo/WYiyI3G0rM1\n" +
            "RA2NM+fIm8x5VX7LjYW+zG4oEG9oFMFDv+JHmwIDAQABAoIBAGWb9yc4ongMkeoY\n" +
            "lxvOANWPv3+XtF8FGdeApUECAK9FexKbWV1tMiBJTS0HbnK9LPUwqhBX3o63BXnf\n" +
            "/f4xNAgedTOJiwmDOt0shEfpxknrL1ulvkbBRcCo7W4pLUCXgtARsF/5GGQgsXfh\n" +
            "IdCvFriQ4rapRhB3uSjVLNK07Pl/PZnpsE6nkfMZjx/GWdW4bnWyFmdjAewNNR4F\n" +
            "7ABFSe0UH/57S9VCKHpPIbR2OCg+tiNmAmcrR0zW3VEeG9SqV+rQ/LCvNkrqWLA3\n" +
            "S3YKhw7JGsqW+lm7lsLY39H+xKemDo7Bn4K7QZHikNojODW/CVnfs9eYSoOZwOcB\n" +
            "A8L17AECgYEA9pwMDi5VVPD+1uSgndYXmoa0T2Uf8nKvLUVgqOHUaryGVRT0o7HC\n" +
            "N6YHRExfTTRhM9gRATy3AlVw/hPr35wr9fLz9dvtGHuvpayv+H5+wo0a/X6aWbhF\n" +
            "dkuBPvAqmjOPFSDJfVDOe4sOvpjWgcSBZDi1xCILHMOBmgRL78k6sdMCgYEA8I9f\n" +
            "ZbnUeAe45ZmTqOqQCoW6ZDNZs5OFGtI1ROsMcIiEyMg724DOf8ggfVymc6S8SmJh\n" +
            "DDlcMczYdT15ZbjDoSac4gFcfGsmhn5iQdJExwaO7eXTC5oGjggFPzFzNP87yb29\n" +
            "+Xq0e5dr1HI/Wo0TpdOXaVp0/DpcYAR3zDshLhkCgYByM09N3dz8SeHph9RtYzBp\n" +
            "CcpEHhNORhejQkaBzpp8lzMqAVtM1suW05b35NoZOZFt3bf6N7CULxb1Qipv0bV1\n" +
            "3v1ktGS2esibUz3mOEXhOFDwZQl7VN8t6cc/ax5/bDLtWNKV6q7D/WBlmQd07pfw\n" +
            "3mYmHpHAzzScKzMzJp+8qwKBgFAuOYnaiqsHR+WfbswagrA/KoVDaF6miPMLpZ23\n" +
            "CopntnqF4w2ivTFyLwIZ45EgE3JnoBlG9SfUM0HAn7n7/5izGg9qjL0bqdeiQHXX\n" +
            "8/yyfulkdRek2xJ0MeuCO/gqKm9vwuZos8eODO7etack5qua/xiqgdugSDHoy1VT\n" +
            "UBfhAoGAJq8aJudJC81ZV+EjRJAdKrmeAmIf4kx8NLqxC07tEojWCsGcIBT6x+CX\n" +
            "cdHLQnfzI7j0semcJGP5h69000gs0NxOAeLztFT46ofYzN//hWghNuSFlO8g31UU\n" +
            "7HccaXKYLyPIqSoI4WswW/mjta/Y1fuYbk9TTCoJ4MR8vWpfgsw=\n" +
            "-----END RSA PRIVATE KEY-----";
    public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEogIBAAKCAQEA57xoXe5pV6ck+htg0rfYZ+qFjZr5pUl8jH6Ls/LmyC39XSKZ\n" +
            "4LMq4b2yX2ZNfUC1wh3tMZ7r0XCAJojD1Rau+naRjNE8CT/lfcj+L7u1My9DVtoH\n" +
            "zvZrNN7FesjwaGGG6M5mgBWZD+cbBCgjyyBHn20kjqVQ6AijWshRUUNGivL/6Q+/\n" +
            "q16LpCbvv2SuxWD7jZPelZDSoWvh2WT8G/+8XB4MWt3qiMiSVrRDsBPVpSZQ63HR\n" +
            "tlblYdfLemfzroFgjav+FGnbjHj78Q7EsnTUfiRNonKSOkLBmqYo/WYiyI3G0rM1\n" +
            "RA2NM+fIm8x5VX7LjYW+zG4oEG9oFMFDv+JHmwIDAQABAoIBAGWb9yc4ongMkeoY\n" +
            "lxvOANWPv3+XtF8FGdeApUECAK9FexKbWV1tMiBJTS0HbnK9LPUwqhBX3o63BXnf\n" +
            "/f4xNAgedTOJiwmDOt0shEfpxknrL1ulvkbBRcCo7W4pLUCXgtARsF/5GGQgsXfh\n" +
            "IdCvFriQ4rapRhB3uSjVLNK07Pl/PZnpsE6nkfMZjx/GWdW4bnWyFmdjAewNNR4F\n" +
            "7ABFSe0UH/57S9VCKHpPIbR2OCg+tiNmAmcrR0zW3VEeG9SqV+rQ/LCvNkrqWLA3\n" +
            "S3YKhw7JGsqW+lm7lsLY39H+xKemDo7Bn4K7QZHikNojODW/CVnfs9eYSoOZwOcB\n" +
            "A8L17AECgYEA9pwMDi5VVPD+1uSgndYXmoa0T2Uf8nKvLUVgqOHUaryGVRT0o7HC\n" +
            "N6YHRExfTTRhM9gRATy3AlVw/hPr35wr9fLz9dvtGHuvpayv+H5+wo0a/X6aWbhF\n" +
            "dkuBPvAqmjOPFSDJfVDOe4sOvpjWgcSBZDi1xCILHMOBmgRL78k6sdMCgYEA8I9f\n" +
            "ZbnUeAe45ZmTqOqQCoW6ZDNZs5OFGtI1ROsMcIiEyMg724DOf8ggfVymc6S8SmJh\n" +
            "DDlcMczYdT15ZbjDoSac4gFcfGsmhn5iQdJExwaO7eXTC5oGjggFPzFzNP87yb29\n" +
            "+Xq0e5dr1HI/Wo0TpdOXaVp0/DpcYAR3zDshLhkCgYByM09N3dz8SeHph9RtYzBp\n" +
            "CcpEHhNORhejQkaBzpp8lzMqAVtM1suW05b35NoZOZFt3bf6N7CULxb1Qipv0bV1\n" +
            "3v1ktGS2esibUz3mOEXhOFDwZQl7VN8t6cc/ax5/bDLtWNKV6q7D/WBlmQd07pfw\n" +
            "3mYmHpHAzzScKzMzJp+8qwKBgFAuOYnaiqsHR+WfbswagrA/KoVDaF6miPMLpZ23\n" +
            "CopntnqF4w2ivTFyLwIZ45EgE3JnoBlG9SfUM0HAn7n7/5izGg9qjL0bqdeiQHXX\n" +
            "8/yyfulkdRek2xJ0MeuCO/gqKm9vwuZos8eODO7etack5qua/xiqgdugSDHoy1VT\n" +
            "UBfhAoGAJq8aJudJC81ZV+EjRJAdKrmeAmIf4kx8NLqxC07tEojWCsGcIBT6x+CX\n" +
            "cdHLQnfzI7j0semcJGP5h69000gs0NxOAeLztFT46ofYzN//hWghNuSFlO8g31UU\n" +
            "7HccaXKYLyPIqSoI4WswW/mjta/Y1fuYbk9TTCoJ4MR8vWpfgsw=\n" +
            "-----END RSA PRIVATE KEY-----";
};

