package com.ipartek.formacion.mf0492.dal;

import com.ipartek.formacion.mf0492.modelos.Usuario;

public interface DaoUsuario {
	Usuario buscarPorNickname(String nickname);
}
