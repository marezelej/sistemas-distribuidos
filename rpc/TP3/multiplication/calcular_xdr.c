/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include "calcular.h"

bool_t
xdr_sumar_1_argument (XDR *xdrs, sumar_1_argument *objp)
{
	 if (!xdr_int (xdrs, &objp->a))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->b))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_restar_1_argument (XDR *xdrs, restar_1_argument *objp)
{
	 if (!xdr_int (xdrs, &objp->a))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->b))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_multiplicar_1_argument (XDR *xdrs, multiplicar_1_argument *objp)
{
	 if (!xdr_int (xdrs, &objp->a))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->b))
		 return FALSE;
	return TRUE;
}
